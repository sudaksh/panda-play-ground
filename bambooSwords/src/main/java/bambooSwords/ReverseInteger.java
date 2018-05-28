package bambooSwords;

public class ReverseInteger {

    public int reverse(int input) {
        boolean isNegative = input < 0;
        if(isNegative)
            input= -input;
        int reversedNum = 0;
        while(input != 0){
            int remainder = input % 10;
            int temp = reversedNum * 10;
            
            if(temp / 10 != reversedNum)
                return 0;
            else if (Integer.MAX_VALUE - temp < remainder)
                return 0;
            reversedNum = temp + remainder;
            input = input /10;
        }
        if(isNegative)
            reversedNum = -reversedNum;
        return reversedNum;
    }
}
