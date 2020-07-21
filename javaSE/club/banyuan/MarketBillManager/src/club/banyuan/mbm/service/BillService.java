package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Bill;
import club.banyuan.mbm.entity.Provider;
import club.banyuan.mbm.exception.BadRequestException;
import club.banyuan.mbm.uti.PropUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BillService {
    private static int billId;
    public static final String BILL_STORE_PATH = "bill.store.path";
    private static List<Bill> billList;

    static {
        load();
        Optional<Bill> max = billList.stream().max(Comparator.comparing(Bill::getId));
        billId = max.map(user -> user.getId() + 1).orElse(1);
    }

    private static void load() {
        File file = new File(PropUtil.getProp(BILL_STORE_PATH));
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] bytes = fileInputStream.readAllBytes();
                billList = JSONObject.parseArray(new String(bytes), Bill.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("账单文件不存在");
            billList = new ArrayList<>();
        }
    }

    private static void save() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PropUtil.getProp(BILL_STORE_PATH))) {
            String jsonStr = JSONObject.toJSONString(billList);
            byte[] bytes = jsonStr.getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Bill> getBillList() {
        return billList;
    }

    public static void addBill(Bill bill, ProviderService providerService) {
        synchronized (billList) {
            if (bill.getIsPay() == 1) {
                bill.setIsPayStr("是");
            } else {
                bill.setIsPayStr("否");
            }
            bill.setId(billId++);
            billList.add(bill);
            for (Provider provider : providerService.getProviderList()) {
                if (provider.getId() == bill.getProviderId()) {
                    bill.setProviderName(provider.getName());
                }
            }
            save();
        }
    }

    public static Bill getBillById(int id) {
        for (Bill bill : billList) {
            if (id == bill.getId()) {
                return bill;
            }
        }
        throw new BadRequestException("账单编号不存在");
    }

    public static void updateBill(Bill bill, ProviderService providerService) {
        Date date = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (bill.getIsPay() == 1) {
            bill.setIsPayStr("是");
        } else {
            bill.setIsPayStr("否");
        }
        Bill billById = getBillById(bill.getId());
        for (Provider provider : providerService.getProviderList()) {
            if (provider.getId() == bill.getProviderId()) {
                billById.setProviderName(provider.getName());
            }
        }
        billById.setIsPay(bill.getIsPay());
        billById.setIsPayStr(bill.getIsPayStr());
        billById.setMoney(bill.getMoney());
        billById.setProduct(bill.getProduct());
        billById.setUpdateTime(dt.format(date));
    }

    public static List<Bill> getBillList(Bill bill) {
        if ((bill.getProduct() == null || bill.getProduct().trim().length() == 0)&&(bill.getIsPay()==-1)) {
            return getBillList();
        }

        List<Bill> list = new ArrayList<>();
        for (Bill bill1 : billList) {
            if ((bill1.getProduct().contains(bill.getProduct().trim()))&&(bill1.getIsPay()==bill.getIsPay())) {
                list.add(bill1);
            }
        }
        return list;
    }

    public static void deleteBillById(int id) {
        List<Bill> list = new ArrayList<>();
        synchronized (billList) {
            for (Bill bill : billList) {
                if (id == bill.getId()) {
                    list.add(bill);
                }
            }
            for (Bill bill : list) {
                billList.remove(bill);
            }
            save();
        }
    }
}
