package backend.models;

public class Exceptions {

    private int id;
    private String exceptionName;
    private  String exceptionDescription;

    public Exceptions(int id, String exceptionName, String exceptionDescription){
        this.id = id;
        this.exceptionName = exceptionName;
        this.exceptionDescription = exceptionDescription;
    }

    public int getId(){ return id;}
    public void setId(int id){ this.id = id; }
    public String getExceptionName(){ return exceptionName;}
    public void setExceptionName(String exceptionName){ this.exceptionName = exceptionName; }
    public String getExceptionDescription(){ return exceptionDescription; }
    public void setExceptionDescription(String exceptionDescription){ this.exceptionDescription = exceptionDescription; }

    @Override
    public String toString() {
        return "Exception{" +
                "ExceptionName='" + exceptionName + '\'' +
                ", ExceptionDescription='" + exceptionDescription + '\'' +
                '}';
    }


}
