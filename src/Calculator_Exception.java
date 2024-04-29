public  class Calculator_Exception extends Exception{
    public Calculator_Exception(){};
    public Calculator_Exception(String message){
        super("제대로 된 값을 입력해 주세요");
    };

}
