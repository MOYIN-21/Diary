import com.CrossFundWallet.application.data.models.Diary;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
@Data
public class DiaryRepositoryImplTest {
    @Autowired
    private DiaryRepositoryImpl diaryRepository;
    @BeforeEach
    public void setUp(){
        diaryRepository = new DiaryRepositoryImpl();
    }
    @Test
    public void saveOneDiary_countIsOneTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());
    }

    @Test public void saveOneDiary_FindDiaryTest(){
        Diary diary = new Diary();
        Diary newDiary = diaryRepository.save(diary);
        assertEquals(newDiary, diaryRepository.findById(diary.getId()));
    }

    @Test public void updateDiaryTest(){
        Diary diary = new Diary();
        diary.setUsername("Glory Sharon");
        diaryRepository.save(diary);
        assertEquals("Glory Sharon", diaryRepository.findById(1).getUsername());
        Diary updatedDiary = new Diary();
        updatedDiary.setId(1);
        updatedDiary.setUsername("Ola Moyinoluwa");
        diaryRepository.save(updatedDiary);
        assertEquals("Ola Moyinoluwa", diaryRepository.findById(1).getUsername());

    }

    @Test public void saveMoreThanOneDiary_countIsAccurateTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        Diary anotherDiary = new Diary();
        diaryRepository.save(anotherDiary);
        Diary extraDiary = new Diary();
        diaryRepository.save(extraDiary);
        assertEquals(extraDiary, diaryRepository.findById(3));
        assertEquals(3, diaryRepository.count());

    }

    @Test public void findingADiaryThatDoesNotExist_ReturnNull(){
        assertNull(diaryRepository.findById(1));
    }


    @Test public void deleteDiary_countReduces(){
        Diary diary = new Diary();
        diary.setUsername("Olawamide Moyinoluwa");
        diaryRepository.save(diary);
        assertEquals("Olawamide Moyinoluwa", diaryRepository.findById(1).getUsername());
        Diary updatedDiary = new Diary();
        updatedDiary.setUsername("Moyinoluwa Shikemi");
        diaryRepository.save(updatedDiary);
        assertEquals("Moyinoluwa Shikemi", diaryRepository.findById(2).getUsername());
        diaryRepository.delete(diary);
        assertEquals(1, diaryRepository.count());
    }























































































    @Test public void clearDiaryTest(){
        Diary diary = new Diary(); diaryRepository.save(diary);
        Diary anotherDiary = new Diary(); diaryRepository.save(anotherDiary);
        Diary extraDiary = new Diary(); diaryRepository.save(extraDiary);
        assertEquals(3, diaryRepository.count());
        diaryRepository.clear();
        assertEquals(0, diaryRepository.count());

    }
    @Test public void AllDiariesCanBeReceivedTest(){
        Diary diary = new Diary(); diaryRepository.save(diary);
        Diary anotherDiary = new Diary(); diaryRepository.save(anotherDiary);
        Diary extraDiary = new Diary(); diaryRepository.save(extraDiary);
        assertEquals(3, diaryRepository.count());
        Iterable<Diary> allDiaries = List.of(new Diary[]{diary, anotherDiary, extraDiary});
        assertEquals(allDiaries, diaryRepository.findAll());
    }


}
