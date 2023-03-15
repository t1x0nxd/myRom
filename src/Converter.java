import java.util.Arrays;
import java.util.StringTokenizer;

class Converter {
    static int ConvertToArab(String input) {
        char[] roma = input.toCharArray();
        String roma1 = String.valueOf(roma[roma.length - 1]);
        RomainNumbers number = RomainNumbers.valueOf(roma1);
        int tempResult = number.getValue();
        int result = tempResult;
        if(roma.length == 1)
            result = tempResult;
        else {
            for (int i = roma.length - 2; i >= 0; i--) {
                String roma2 = String.valueOf(roma[i]);
                RomainNumbers number1 = RomainNumbers.valueOf(roma2);
                int arab = number1.getValue();
                if (arab >= tempResult) {
                    result += arab;
                } else {
                    result -= arab;
                }
                tempResult = arab;
            }
        }
        return result;
    }


    static String ConvertToRoma(int number)  {
        if(number < 0) throw new IllegalArgumentException("Нельзя конвертировать такое");
        String s1 = Arrays.toString(RomainNumbers.values());
        String s2 = null;
        StringTokenizer tokenizer = new StringTokenizer(s1,"[]");
        while(tokenizer.hasMoreTokens())
            s2 = tokenizer.nextToken();
        String[] s3 = s2.split(", ");
        String [] s4 = new String[s3.length];
        int index = s3.length -1;
        for (int i = 0; i <= index ; i++) {
            s4[i] = s3[index - i];
        }
        StringBuilder sb = new StringBuilder();
        String cur;
        int i = 0;
        while((number > 0) &&(i < s4.length) ){
            cur = s4[i];
            RomainNumbers currentS = RomainNumbers.valueOf(cur);
            if(currentS.getValue() <= number){
                sb.append(currentS.name());
                number -= currentS.getValue();
            }
            else {
                i++;
            }

        }
        return sb.toString();

    }


}
