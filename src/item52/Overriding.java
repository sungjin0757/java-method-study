package item52;

import java.util.List;

class Wine{
    String name(){
        return "포도주";
    }
}

class SparklingWine extends Wine{
    @Override
    String name() {
        return "발포성 포도주";
    }
}

class Champagne extends SparklingWine{
    @Override
    String name() {
        return "샴페인";
    }
}

public class Overriding {
    public static void main(String[] args){
        List<Wine> wineList = List.of(new Wine(), new SparklingWine(),
                new Champagne());

        // for 문에서 compile 타입이 모두 wine이지만, 동적으로 overriding됨.
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}
