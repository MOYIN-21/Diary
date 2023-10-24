//import com.CrossFundWallet.application.data.models.Entry;
//import data.repositories.EntryRepositoryImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class EntryRepositoryImplTest {
//    private EntryRepositoryImpl entryRepository;
//    @BeforeEach
//    void setUp() {
//        entryRepository = new EntryRepositoryImpl();
//    }
//
//    @Test public void saveEntry_countIncreases() {
//        Entry entry = new Entry();
//        entryRepository.save(entry);
//        assertEquals(1, entryRepository.count());
//    }
//    @Test public void saveOneDiary_FindEntryTest(){
//        Entry entry = new Entry();
//        Entry newEntry = entryRepository.save(entry);
//        assertEquals(newEntry, entryRepository.findById(1));
//
//    }
//
//    @Test public void updateEntryTest(){
//        Entry entry = new Entry();
//        entry.setTitle("Hello");
//        entry.setBody("While alive, code");
//        entryRepository.save(entry);
//        assertEquals("Hello", entryRepository.findById(1).getTitle());
//        assertEquals("While alive, code", entryRepository.findById(1).getBody());
//        Entry updateEntry = new Entry();
//        updateEntry.setId(1);
//        updateEntry.setTitle("Hello");
//        updateEntry.setBody("Hello, " + "While alive, code");
//        entryRepository.save(updateEntry);
//        assertEquals("While alive, code", entryRepository.findById(1).getTitle());
//        assertEquals("Hello, " + "While alive, code", entryRepository.findById(1).getBody());
//    }
//    @Test public void findingAEntryThatDoesNotExist_ReturnNull(){
//        assertNull(entryRepository.findById(1));
//    }
//
//    @Test public void deleteEntry_reducesCount() {
//        Entry entry = new Entry();
//        entry.setTitle("In everything you do");
//        entry.setBody("get money");
//        entryRepository.save(entry);
//        Entry updateEntry = new Entry();
//        updateEntry.setTitle("In everything you do");
//        updateEntry.setBody("In everything you do, " + "get money");
//        entryRepository.save(updateEntry);
//        assertEquals(2, entryRepository.count());
//        entryRepository.delete(entry);
//        assertEquals(1, entryRepository.count());
//
//    }
//    @Test public void clearEntryTest(){
//        Entry entry = new Entry(); entryRepository.save(entry);
//        Entry newEntry = new Entry(); entryRepository.save(newEntry);
//        Entry extraEntry = new Entry(); entryRepository.save(extraEntry);
//        assertEquals(3, entryRepository.count());
//        entryRepository.clear();
//        assertEquals(0, entryRepository.count());
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Test
//    public void AllEntriesCanBeReceivedTest() {
//        Entry entry = new Entry();
//        entryRepository.save(entry);
//        Entry newEntry = new Entry();
//        entryRepository.save(newEntry);
//        Entry extraEntry = new Entry();
//        entryRepository.save(extraEntry);
//        assertEquals(3, entryRepository.count());
//        Iterable<Entry> allEntries = List.of(new Entry[]{entry, newEntry, extraEntry});
//        assertEquals(allEntries, entryRepository.findAll());
//    }
//
//
//    @Test public void moreEntries_increasesCount(){
//        Entry entry = new Entry();
//        entry.setTitle("Hello, while alive");
//        entry.setBody("Code");
//        entryRepository.save(entry);
//        Entry updateEntry = new Entry();
//        updateEntry.setTitle("Hello, while alive");
//        updateEntry.setBody("Hello, while alive" + "Code");
//        entryRepository.save(updateEntry);
//        assertEquals(2, entryRepository.count());
//    }
//}
