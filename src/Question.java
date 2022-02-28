public class Question {
    private String statement;
    private boolean trueOrFalse;
    private int puntuation;
    private boolean usersAnswer;
    private String theme;

    public Question(String statement, boolean trueOrFalse, int puntuation, String theme) {
        this.statement = statement;
        this.trueOrFalse = trueOrFalse;
        this.puntuation = puntuation;
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public boolean isUsersAnswer() {
        return usersAnswer;
    }

    public void setUsersAnswer(boolean usersAnswer) {
        this.usersAnswer = usersAnswer;
    }

    public int getPuntuation() {
        return puntuation;
    }

    public String getStatement() {
        return statement;
    }

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }

}