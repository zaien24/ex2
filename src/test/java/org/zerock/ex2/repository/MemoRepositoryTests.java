package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.entity.Memo;

import java.util.Optional;
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

    @Test
    public void testSelect() {

        //데이터베이스에 존재하는 mno
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Transactional
    @Test
    public void testSelect2() {

        //데이터베이스에 존재하는 mno
        Long mno = 100L;

        Memo memo = memoRepository.getOne(mno);

        System.out.println("================");

        System.out.println(memo);
    }

}

