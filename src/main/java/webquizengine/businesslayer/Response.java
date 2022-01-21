package webquizengine.businesslayer;

public class Response {
    private boolean success;
    private String feedback;

    public Response(boolean success) {
        this.success = success;
        this.feedback = success ? "Congratulations, you're right!"
                : "Wrong answer! Please, try again.";
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}