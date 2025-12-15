package StringPlay;

public class validAbbrev408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordLen = word.length();
        int abbrLen = abbr.length();
        int shortCursor = 0;
        int longCursor = 0;
        while(longCursor<wordLen && shortCursor<abbrLen){
            char c = abbr.charAt(shortCursor);
            if(Character.isDigit(c)){
                if(c=='0'){
                    return false;
                }
                int num = 0;
                while(shortCursor<abbrLen && Character.isDigit(abbr.charAt(shortCursor))){
                    num  = num*10 +  (abbr.charAt(shortCursor)-'0');
                    shortCursor++;
                }
                longCursor+=num;
            }else{
                if(longCursor==wordLen || word.charAt(longCursor)!=c)return false;
                shortCursor++;
                longCursor++;
            }
        }
        return shortCursor==abbrLen && longCursor==wordLen;

    }
}
