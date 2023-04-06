/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < this.size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (this.get(r.uuid) == null)
            storage[this.size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                for (int j = i; j < storage.length - 1; j++)
                    storage[j] = storage[j + 1];
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = this.size();
        if (size > 0) {
            Resume[] resumes = new Resume[size];
            System.arraycopy(storage, 0, resumes, 0, size);
            return resumes;
        }
        return new Resume[0];
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) return i;
        }
        return storage.length;
    }
}
