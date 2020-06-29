package club.banyuan.June29.Practic;

public class AnimalType {

    public static final AnimalType LION = new AnimalType("狮子",1);
    public static final AnimalType ELEPHANT = new AnimalType("大象",2);
    public static final AnimalType TIGER = new AnimalType("老虎",3);
    public static final AnimalType UNKNOW=new AnimalType("未知物种",0);

    private String name;
    private int id;

    private AnimalType(String name,int id) {
        this.name = name;this.id=id;
    }

    @Override
    public String toString() {
        return name;
    }
    public int toInt(){
        return id;
    }

    public static AnimalType valueOf(String typeName) {
        if (LION.name.equals(typeName)) {
            return LION;
        } else if (ELEPHANT.name.equals(typeName)) {
            return ELEPHANT;
        } else if(TIGER.name.equals(typeName)){
            return TIGER;
        }else {
            return UNKNOW;
        }
    }
    public static AnimalType valueOf(int typeId){
        if(LION.id==typeId){
            return LION;
        }else if(ELEPHANT.id==typeId){
            return ELEPHANT;
        }else if(TIGER.id==typeId){
            return TIGER;
        }else{
            return UNKNOW;
        }
    }
}
