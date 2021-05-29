package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	// 'WHERE BNO > 0'과 같은 조건은 테이블을 검색할 때 PK를 이용하도록 유도하는 조건
	// @Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
	public List<BoardVO> getList();
}
