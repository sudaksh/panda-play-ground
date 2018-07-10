package bambooSwords;

public class RegularExpressionMatcher {


    public boolean isMatch(String s, String p) {

        if(p.length() == 0){
            return s.length() == 0;
        }

        if(p.length() == 1){
            if(s.length() == 0){
                return false;
            }
            if(p.charAt(0) != s.charAt(0) && p.charAt(0) != '.'){
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }

        if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'){
            if(p.charAt(1) == '*'){

                String patternAfterStar = p.substring(2);

                int i = 1;

                while(i <= s.length()){
                    
                    if(isMatch(s.substring(i), patternAfterStar)){
                        return true;
                    } else if (s.charAt(i) != p.charAt(0) && p.charAt(0) != '.' ) {
                        return false;
                    }
                    i++;
                    
//  aab", "c*a*b
                    
                }
                return false;

            } else {
                return isMatch(s.substring(1), p.substring(1));
            }

        } else {
            return false;
        }

    }


    //    b  bbbbcdghj
    //    b*   dghj   b*.d
    //    .*d




    //    public boolean isMatch(String s, String p) {
    //
    //        if(p.length() == 0)
    //            return s.length() == 0;
    //        //p's length 1 is special case
    //        if(p.length() == 1 || p.charAt(1) != '*'){
    //            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
    //                return false;
    //            return isMatch(s.substring(1), p.substring(1));
    //        }else{
    //            int len = s.length();
    //            int i = -1;
    //            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
    //                if(isMatch(s.substring(i+1), p.substring(2)))
    //                    return true;
    //                i++;
    //            }
    //            return false;
    //        }
    //    }


}
