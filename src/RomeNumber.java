public class RomeNumber {
    private static final String[] romeCharacters = {"I","V","X","L","C","D","M"};
    private int computable = 0;
    private String number = "";

    public RomeNumber(String number) {
        if(!this.validate(number)) {
            System.out.println("Number " + number + " has incorrect symbols");
            this.computable = 0;
            this.number = "0";
        }
        else {
            this.number = number;
            this.computable = this.toInt(number);
        }
        System.out.println(this.number + " == " + this.computable);
    }

    private boolean validate(String number) {
        return number.matches("^[IVXLCDM]+$") || number.equals("0");
    }

    private int toInt(String number) {
        int result = 0;
        if(number=="0") {
            return 0;
        }

        while(!number.isEmpty()) {
            if (number.endsWith("CM")) {
                result += 900;
                number = number.substring(0,number.length()-2);
            } else if (number.endsWith("M")) {
                result += 1000;
                number = number.substring(0,number.length()-1);
            } else if(number.endsWith("CD")) {
                result += 400;
                number = number.substring(0,number.length()-2);
            } else if (number.endsWith("D")) {
                result += 500;
                number = number.substring(0,number.length()-1);
            } else if (number.endsWith("XC")) {
                result += 90;
                number = number.substring(0,number.length()-2);
            } else if (number.endsWith("C")) {
                result += 100;
                number = number.substring(0,number.length()-1);
            } else if (number.endsWith("XL")) {
                result += 40;
                number = number.substring(0,number.length()-2);
            } else if (number.endsWith("L")) {
                result += 50;
                number = number.substring(0,number.length()-1);
            } else if (number.endsWith("IX")) {
                result += 9;
                number = number.substring(0,number.length()-2);
            } else if (number.endsWith("X")) {
                result += 10;
                number = number.substring(0,number.length()-1);
            }  else if (number.endsWith("IV")) {
                result += 4;
                number = number.substring(0,number.length()-2);
            } else if (number.endsWith("V")) {
                result += 5;
                number = number.substring(0,number.length()-1);
            } else if (number.endsWith("I")) {
                result += 1;
                number = number.substring(0,number.length()-1);
            }
        }

        return result;
    }

    private String toRome() {
        String computableNumber = String.valueOf(this.computable);
        String number = "";
        for (int i = 0; i < computableNumber.length(); i++) {
            number += toRomeConverter(computableNumber.charAt(i),computableNumber.length()-i-1);
        }
        return number;
    }

    private static String toRomeConverter(char number, int scale) {

        switch (number) {
            case '1' -> {
                return romeCharacters[scale * 2];
            }
            case '2' -> {
                return romeCharacters[scale * 2] + romeCharacters[scale * 2];
            }
            case '3' -> {
                return romeCharacters[scale * 2] + romeCharacters[scale * 2] + romeCharacters[scale * 2];
            }
            case '4' -> {
                return romeCharacters[scale * 2] + romeCharacters[1 + scale * 2];
            }
            case '5' -> {
                return romeCharacters[1 + scale * 2];
            }
            case '6' -> {
                return romeCharacters[1 + scale * 2] + romeCharacters[scale * 2];
            }
            case '7' -> {
                return romeCharacters[1 + scale * 2] + romeCharacters[scale * 2] + romeCharacters[scale * 2];
            }
            case '8' -> {
                return romeCharacters[1 + scale * 2] + romeCharacters[scale * 2] + romeCharacters[scale * 2] + romeCharacters[scale * 2];
            }
            case '9' -> {
                return romeCharacters[scale * 2] + romeCharacters[2 + scale * 2];
            }
            default -> {
                return "";
            }
        }
    }

    public String toString() {
        return this.number;
    }

    protected int getComputable() {
        return this.computable;
    }

    public void add(RomeNumber number) {
        this.computable += number.getComputable();
        this.number = toRome();
    }

    public void substract(RomeNumber number) {
        this.computable -= number.getComputable();
        this.number = toRome();
    }

    public void multiply(RomeNumber number) {
        this.computable *= number.getComputable();
        this.number = toRome();
    }

    public void divide(RomeNumber number) {
        this.computable /= number.getComputable();
        this.number = toRome();
    }

    public void setValue(String number) {
        if(!this.validate(number)) {
            System.out.println("Number " + number + " has incorrect symbols");
        }
        else {
            this.number = number;
            this.computable = this.toInt(number);
        }
        System.out.println(this.number + " == " + this.computable);
    }
}
