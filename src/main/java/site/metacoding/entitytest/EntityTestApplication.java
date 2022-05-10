package site.metacoding.entitytest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import site.metacoding.entitytest.domain.Board;
import site.metacoding.entitytest.domain.BoardRepository;

@SpringBootApplication
public class EntityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityTestApplication.class, args);
	}

	// Bean이 메모리에 올려줌. 실행시점은
	@Bean
	public CommandLineRunner initData(BoardRepository boardRepository) {
		return (args) -> {

			List<Board> boards = new ArrayList<>();

			for (int i = 1; i < 3; i++) {
				Board board = new Board();
				board.setTitle("제목" + i);
				board.setContent("내용" + i);
				boards.add(board);
			}

			boardRepository.saveAll(boards);

		};

	}
}
