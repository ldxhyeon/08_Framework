package repet.ldh.project.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repet.ldh.project.board.dto.Board;
import repet.ldh.project.main.mapper.MainMapper;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{
	
	private final MainMapper mapper;
	

}
