package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Provider;
import club.banyuan.mbm.exception.BadRequestException;
import club.banyuan.mbm.uti.PropUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ProviderService {
    private static int providerId;
    public static final String PROVIDER_STORE_PATH = "provider.store.path";
    private static List<Provider> providerList;

    static {
        load();
        Optional<Provider> max = providerList.stream().max(Comparator.comparing(Provider::getId));
        providerId = max.map(user -> user.getId() + 1).orElse(1);
    }

    private static void load() {
        File file = new File(PropUtil.getProp(PROVIDER_STORE_PATH));
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] bytes = fileInputStream.readAllBytes();
                providerList = JSONObject.parseArray(new String(bytes), Provider.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("供应商文件不存在");
            providerList = new ArrayList<>();
        }
    }

    private static void save() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PropUtil.getProp(PROVIDER_STORE_PATH))) {
            String jsonStr = JSONObject.toJSONString(providerList);
            byte[] bytes = jsonStr.getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Provider> getProviderList() {
        return providerList;
    }

    public static void setProviderList(List<Provider> providerList) {
        ProviderService.providerList = providerList;
    }

    public static void main(String[] args) {
        providerList = new ArrayList<>();
        Provider p1 = new Provider();
        p1.setId(0);
        p1.setName("张三");
        p1.setDesc("1234");
        p1.setPhone("13312345678");
        p1.setContactPerson("李四");

        providerList.add(p1);
        save();
    }

    public void addProvider(Provider provider) {
        synchronized (providerList) {
            provider.setId(providerId++);
            providerList.add(provider);
            save();
        }
    }

    public Provider getProviderById(int id) {
        for (Provider provider : providerList) {
            if (id == provider.getId()) {
                return provider;
            }
        }
        throw new BadRequestException("供应商id不存在");
    }

    public void updateProvider(Provider provider) {
        Provider providerById = getProviderById(provider.getId());
        providerById.setPhone(provider.getPhone());
        providerById.setDesc(provider.getDesc());
        providerById.setName(provider.getName());
        providerById.setContactPerson(provider.getContactPerson());
        save();
    }

    public List<Provider> getProviderList(Provider provider) {
        if (provider.getName() == null || provider.getName().trim().length() == 0) {
            return getProviderList();
        }
        List<Provider> list = new ArrayList<>();
        for (Provider provider1 : providerList) {
            if (provider1.getName().contains(provider.getName().trim())) {
                list.add(provider1);
            }
        }
        return list;
    }



    public void deleteUserById(int id) {
        List<Provider> list = new ArrayList<>();
        synchronized (providerList) {
            for (Provider provider : providerList) {
                if (provider.getId() == id) {
                    list.add(provider);
                }
            }
            for (Provider provider : list) {
                providerList.remove(provider);
            }
            save();
        }

    }

}
