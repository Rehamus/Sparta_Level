public enum OperatorType {
    ADD(new AddOperator()),
    SUB(new SubtractOperator()),
    DIV(new DivideOperator()),
    MLT(new MultiplyOperator()),
    MOD(new ModOperator());

    private AllOperator operator;

    OperatorType(AllOperator operator) {
        this.operator = operator;
    }

    public AllOperator getOperator() {
        return operator;
    }

    public void setOperator(AllOperator operator) {
        this.operator = operator;
    }

}