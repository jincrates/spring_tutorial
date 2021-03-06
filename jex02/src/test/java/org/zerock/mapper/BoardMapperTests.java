package org.zerock.mapper;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { org.zerock.config.RootConfig.class })
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Ignore
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Ignore
	public void testInsert() {
		BoardVO board = new  BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		//mapper.insert(board);
		mapper.insertSelectKey(board);
		
		// Lombok이 만들어주는 toString()을 이용해서 bno 멤버 변수의 값을 알아보기 위함
		log.info(board);
	}
	
	@Ignore
	public void testRead() {
		
		// 존재하는 게시물 번호로 테스트 
		BoardVO board = mapper.read(7L);
		
		log.info(board);
	}
	
	@Ignore
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}
	
	@Ignore
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		// 실행전 존재하는 번호인지 확인할 것
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		// 10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board.getBno()));
	}
}
