package item33;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
//        favorites.put(Objects.requireNonNull(type), instance); //일반적
        // 클라에서 로 타입으로 instance를 넘기면 안선정 깨짐
        // 해결
//        favorites.put(Objects.requireNonNull(type), type.cast(instance));// 얘는 cast에서 인스턴스의 type이랑 instance타입이랑 같은지 체크하는 코드가 유의미하다.
        favorites.put(Objects.requireNonNull(type), (T)instance);// 얘도 굳이?

    }

    public <T> T getFavorite(Class<T> type) {
//        return type.cast(favorites.get(type));
        // 왜 굳이 type.cast 사용할까 ->
        // cast가 반환 타입이 Class객체의 타입 매개변수와 같아서 라는데(cast 메서드의 시그니처가 Class 클래스가 제네릭이라는 이점을 완벽히 활용)
        // 음.. (T) 랑 뭐가 다름?
        // cast 메소드 보면 결국 return (T) obj; 인데??
        return (T) favorites.get(type);
        // put 에서 만약 로 타입 안정성 꺠지게 들어오면 cast할때 에러 터짐
        // 근데 (T)면 못 거르게 된다?!
    }

    public static void main(String[] args) {
//        Favorites f = new Favorites();
//        f.putFavorites(String.class, "JAVA");
//        f.putFavorites(Integer.class, 0xcafebabe);
//        f.putFavorites(Class.class, Favorites.class);
//        f.putFavorites((Class) Integer.class, "Integer인스턴스가 아니다.!"); // Integer Key에 String들어가버림.
//        String favorite = f.getFavorite(String.class);
//        Integer favorite1 = f.getFavorite(Integer.class);
//        Class favorite2 = f.getFavorite(Class.class);
//        System.out.printf("%s %x %s%n", favorite, favorite1, favorite2.getName());

        System.out.println("====================");

        Class<String[]> aClass = String[].class;
        System.out.println("aClass = " + aClass);
        Class<String> stringClass = String.class;
        System.out.println("stringClass = " + stringClass);
    }
}
