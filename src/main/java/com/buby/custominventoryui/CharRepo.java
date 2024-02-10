package com.buby.custominventoryui;

public enum CharRepo {

    //Spacing Characters
    NEG1("\uF801"),
    NEG2("\uF802"),
    NEG4("\uF804"),
    NEG8("\uF808"),
    NEG16("\uF809"),
    NEG32("\uF80A"),
    NEG64("\uF80B"),
    NEG128("\uF80C"),
    NEG256("\uF80D"),
    NEG512("\uF80E"),
    NEG1024("\uF80F"),
    
    POS1("\uF821"),
    POS2("\uF822"),
    POS4("\uF824"),
    POS8("\uF828"),
    POS16("\uF829"),
    POS32("\uF82A"),
    POS64("\uF82B"),
    POS128("\uF82C"),
    POS256("\uF82D"),
    POS512("\uF82E"),
    POS1024("\uF82F"),

    MENU_CONTAINER_27("\uF001"),
    MENU_BUTTON("\uF002");

    public final String literal;
    CharRepo(String literal){
        this.literal = literal;
    }

    @Override
    public String toString(){
        return this.literal;
    }

    private enum SpacingCharacters{
        NEG1(-1, CharRepo.NEG1),
        NEG2(-2, CharRepo.NEG2),
        NEG4(-4, CharRepo.NEG4),
        NEG8(-8, CharRepo.NEG8),
        NEG16(-16, CharRepo.NEG16),
        NEG32(-32, CharRepo.NEG32),
        NEG64(-64, CharRepo.NEG64),
        NEG128(-128, CharRepo.NEG128),
        NEG256(-256, CharRepo.NEG256),
        NEG512(-512, CharRepo.NEG512),
        NEG1024(-1024, CharRepo.NEG1024),

        POS1(1, CharRepo.POS1),
        POS2(2, CharRepo.POS2),
        POS4(4, CharRepo.POS4),
        POS8(8, CharRepo.POS8),
        POS16(16, CharRepo.POS16),
        POS32(32, CharRepo.POS32),
        POS64(64, CharRepo.POS64),
        POS128(128, CharRepo.POS128),
        POS256(256, CharRepo.POS256),
        POS512(512, CharRepo.POS512),
        POS1024(1024, CharRepo.POS1024);
        
        private final int weight;
        private final CharRepo charRef;

        SpacingCharacters(int weight, CharRepo charRef){
            this.weight = weight;
            this.charRef = charRef;
        }
    }

    public static CharRepo getCharacterByWeight(int weight){
        for(SpacingCharacters ch : SpacingCharacters.values()){
            if(ch.weight == weight)
                return ch.charRef;
        }
        return null;
    }

    public static String getSpacing(int pixelAmount){
        //convert amount to binary string
        String binary = new StringBuilder(Integer.toBinaryString(Math.abs(pixelAmount))).reverse().toString();
        StringBuilder sb = new StringBuilder();
        char[] chArr = binary.toCharArray();
        for(int index = 0; index < chArr.length; index++){
            char ch = chArr[index];
            if(ch == '0') continue;

            int weight = (int)Math.pow(2, index);
            //if we are getting negative, flip weight
            weight = pixelAmount < 0 ? -weight : weight;
            CharRepo ref = getCharacterByWeight(weight);

            if(ref != null)
                sb.append(ref.literal);
        }
        return sb.toString();
    }

    public static String getNeg(int pixelAmount){
        return getSpacing(-Math.abs(pixelAmount));
    }

    public static String getPos(int pixelAmount){
        return getSpacing(Math.abs(pixelAmount));
    }
}




























