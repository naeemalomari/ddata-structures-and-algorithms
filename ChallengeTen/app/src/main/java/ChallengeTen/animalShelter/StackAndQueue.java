package ChallengeTen.animalShelter;

import ChallengeTen.stack.structure.Stack;

public class StackAndQueue {


    public Boolean validateBrackets(String index){
        Stack stack = new Stack();

        for (int i = 0; i < index.length(); i++) {
            char item = index.charAt(i);
            if(item == '{' || item == '(' || item == '['){
                stack.push(item + "");
            } else if(item == '}' || item == ')' || item == ']'){
                String value = stack.peek();
                if(((item+"").equals('}' + "")&&value.equals( '{' + "" ) || (item+"").equals(')' + "")&&value.equals( '(' + "" ) ||(item+"").equals(']' + "")&& value.equals( '[' + "" )) && !stack.isEmpty()){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
