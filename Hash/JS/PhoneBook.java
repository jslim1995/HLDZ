package Hash.JS;

import java.util.Arrays;
import java.util.HashSet;

/**
 * PhoneBook
 * ["119", "97674223", "1195524421"]
 * ["123","456","789"]
 * ["12","123","1235","567","88"]
 */
public class PhoneBook {
    public boolean solution(String[] phone_book) {
        // 테스트는 다 통과하는데, 효율성 구림... (웨지?)
        for(int i = 0; i < phone_book.length/2 + 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                } else if(phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solution3(String[] phone_book) {
        for(int i = 0; i < phone_book.length/2 + 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].length() > phone_book[j].length()) {
                    if(phone_book[i].startsWith(phone_book[j])) {
                        return false;
                    }
                } else if(phone_book[i].length() < phone_book[j].length()) {
                    if(phone_book[j].startsWith(phone_book[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean solution2(String[] phone_book) {
        
        for(String string1 : phone_book) {
            for (String string2 : phone_book) {
                if(string1.length() > string2.length()) {
                    if(string1.startsWith(string2)) {
                        return false;
                    }
                } else if(string1.length() < string2.length()) {
                    if(string2.startsWith(string1)) {
                        return false;
                    }
                }
            }
        }

        
        return true;
    }

    public boolean solution4(String[] phone_book) {
        HashSet pb = new HashSet<String>(Arrays.asList(phone_book));
        
        for(String string : phone_book) {
            for(int i = 0; i < string.length(); i++) {
                if(pb.contains(string.substring(0, i))) {
                   return false; 
                }
            }
        }

        
        return true;
    }
}