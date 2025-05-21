package bg.tu_varna.sit.library_training;

public class ResourceNotFound extends Exception {
    public ResourceNotFound(String message, Class item) {
        super(String.format("Resource with id = %s from class = %s", message,  item.getName()));
    }
}
