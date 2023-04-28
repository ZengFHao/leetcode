package d641;

class MyCircularDeque {
    private int[] strings ;
    private int len;
    private int index = 0;

    public MyCircularDeque(int k) {
        strings = new int[k];
        len = k;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        else {
            for(int i = index;i >0; i--){
                strings[i] = strings[i - 1];
            }
            strings[0] = value;
            index++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        else {
            strings[index] = value;
            index++;
            return true;
        }
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        else{
            for(int i = 0; i<index - 1; i++){
                strings[i] = strings[i+1];
            }
            index--;
            return true;
        }
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        else{
            index--;
            return true;
        }
    }

    public int getFront() {
        if(isEmpty()) return -1;
        else return strings[0];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        else return strings[index - 1];
    }

    public boolean isEmpty() {
        if(index == 0) return true;
        else return false;
    }

    public boolean isFull() {
        if(index == len ) return true;
        else  return false;
    }
}
