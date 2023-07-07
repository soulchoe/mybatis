package com.mybatis.dy.model.vo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Board {
	private int boardNo;
	private String boardTitle;
	private Member mem;
	private String boardContent;
//	private String boardOrininalFilename;
//	private String boardRenameFilename;
	private Date boardDate;
	private int boardRead;
	private List<BoardComment> comments;
}
