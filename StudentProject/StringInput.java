public class StringInput {
    private String name;
    private int maxLength;
    private String regexPattern;
    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRegexPattern() {
        return this.regexPattern;
    }

    public void setRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    } 

}