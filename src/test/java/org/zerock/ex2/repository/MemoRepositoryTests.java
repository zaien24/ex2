package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex2.entity.Memo;

import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){

        System.out.println(memoRepository.getClass().getName());

    }

    @Test
    public void testInsertDummies() {

//        for (int i = 0; i < 100; i++) {
//            Memo memo = new Memo();
//            Memo.builder().memoText("Sample..." + i);
//            memoRepository.save(memo);
//        }
//
//        IntStream.range(0, 100).forEach(i -> {
//            Memo memo = new Memo();
//            Memo.builder().memoText("Sample..." + i);
//            memoRepository.save(memo);
//        });

        IntStream.range(0, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });
    }
}
