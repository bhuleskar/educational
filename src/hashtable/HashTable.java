package hashtable;

public class HashTable {
    private static final boolean DEBUG_ENABLED = false;
    private static final int INITIAL_SIZE = 16;
    private final HashEntry[] entries = new HashEntry[INITIAL_SIZE];

    public void put(final String key, final String value) {
        final int hash = getHash(key);
        final HashEntry hashEntry = new HashEntry(key, value);
        if (this.entries[hash] == null) {
            this.entries[hash] = hashEntry;
        }
        // --collision--
        // If there is already an entry at current hash
        // position, add entry to the linked list.
        else {
            HashEntry temp = this.entries[hash];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }

    /**
     * @return get's the value for the given key.
     * returns {@code null} if the element is not found.
     */
    public String get(final String key) {
        final int hash = getHash(key);
        if (this.entries[hash] != null) {
            HashEntry temp = this.entries[hash];

            // Check the entry in the linked list,
            // march for the given 'key'
            while (!temp.key.equals(key)
                    && temp.next != null) {
                temp = temp.next;
            }

            if (temp.key.equals(key)) {
                return temp.value;
            }
            //no elements matched in the chained hash entry list
            //continue to failover to return null
        }

        //no elements in the map that matches the hash
        return null;
    }

    private int getHash(final String key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }

    public static class HashEntry {
        final String key;
        final String value;
        // Linked list of same hash entries.
        HashEntry next;

        public HashEntry(final String key, final String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + this.key + ", " + this.value + "]";
        }
    }

    @Override
    public String toString() {
        int bucket = 0;
        final StringBuilder hashTableStr = new StringBuilder();
        for (final HashEntry entry : this.entries) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            HashEntry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
            bucket++;
        }
        return hashTableStr.toString();
    }

    public static void main(final String[] args) {
        final HashTable hashTable = new HashTable();
        // Put some key values.
        for (int i = 0; i < 30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, "value->" + key);
        }

        // Print the HashTable structure
        log("****   HashTable  ***");
        log(hashTable.toString());
        log("\nValue for key(20) : " + hashTable.get("20"));

        //valid test
        for (int i = 0; i < 30; i++) {
            debug("get(= " + i + ")");
            assert hashTable.get(String.valueOf(i)) != null;
        }
        //exhaustive invalid test case
        for (int i = 31; i < 10000; i++) {
            debug("get(= " + i + ")");
            assert hashTable.get(String.valueOf(i)) == null;
        }
    }

    private static void log(final String msg) {
        System.out.println(msg);
    }

    private static void debug(final String msg) {
        if (DEBUG_ENABLED) System.out.println(msg);
    }
}
