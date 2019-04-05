package AppUtil;

public enum FilePath {
    SETTING ("settings.json"),
    TABLE ("tables.json");

    public final String path;
    FilePath(String path) {
        this.path = path;
    }
}
