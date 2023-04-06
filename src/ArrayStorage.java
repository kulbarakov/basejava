/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (this.get(r.uuid) == null) {
            storage[size] = r;
            size++;
        } else System.out.println("Такое резюме уже есть в базе");
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                for (int j = i; j < size - 1; j++)
                    storage[j] = storage[j + 1];
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size > 0) {
            Resume[] resumes = new Resume[size];
            System.arraycopy(storage, 0, resumes, 0, size);
            return resumes;
        }
        return new Resume[0];
    }

    int size() {
        return size;
    }
}
