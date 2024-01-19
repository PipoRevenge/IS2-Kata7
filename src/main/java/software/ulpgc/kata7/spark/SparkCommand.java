package software.ulpgc.kata7.spark;

public interface SparkCommand {

    Output execute(Input input);

    public interface Output {
        int code();
        String result();
    }

    public interface Input {
        String get(String key);

    }

    static Output output(int code,String result) {
        return new Output() {
            @Override
            public int code() {
                return code;
            }

            @Override
            public String result() {
                return result;
            }
        };
    }
}
