public class InputVerifierModel {
    private String name;
    private String regexPattern;
    private String errorMessage;
    
    public InputVerifierModel(String name, String regexPattern, String errorMessage) {
        this.name = name;
        this.regexPattern = regexPattern;
        this.errorMessage = errorMessage;
    }

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

    public void setName(String name) {
        this.name = name;
    }
}