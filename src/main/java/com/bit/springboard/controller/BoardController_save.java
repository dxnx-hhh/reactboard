//package com.bit.springboard.controller;
//
//import com.bit.springboard.dto.BoardDTO;
//import com.bit.springboard.dto.ResponseDTO;
//import com.bit.springboard.entity.Board;
//import com.bit.springboard.service.BoardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController //화면단으로 이동할 떄는 ModelAndView 객체를 리턴해서 처리
//@RequestMapping("/board")
//public class BoardController_save {
//    private BoardService boardService; //다형성을 위해 임플 형태의 변수가 아니라 부모 형태의 변수를 사용함
//
//    @Autowired
//    public BoardController_save(BoardService boardService) {
//        this.boardService = boardService; //생성자 주입
//    }
//
//
//    @GetMapping("/board-list")
//    public ResponseEntity<?> getBoardList() {
//        ResponseDTO<BoardDTO> responseDTO = new ResponseDTO<>();
//
//        try{
//            List<Board> boardList = boardService.getBoardList();
//
//            List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();
//
//            for(Board b : boardList) {
//
//                BoardDTO returnBoardDTO = BoardDTO.builder()
//                                                  .boardNo(b.getBoardNo())
//                                                  .boardTitle(b.getBoardTitle())
//                                                  .boardContent(b.getBoardContent())
//                                                  .boardWriter(b.getBoardWriter())
//                                                  .boardRegDate(b.getBoardRegdate().toString())
//                                                  .boardCnt(b.getBoardCnt())
//                                                  .build();
//
//                boardDTOList.add(returnBoardDTO);
//            }
//
//            responseDTO.setItems(boardDTOList);
//
//            return ResponseEntity.ok().body(responseDTO);
//
//        } catch (Exception e) {
//            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
//            responseDTO.setErrorMessage(e.getMessage());
//
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//
//    }
//
//    @PostMapping("/board")
//    public ResponseEntity<?> insertBoard(BoardDTO boardDTO) {
//        ResponseDTO<Map<String, String>> responseDTO = new ResponseDTO<>();
//
//        try{
//            //BoardEntity에 지정한 boardRegdate의 기본값은 기본생성자 호출할 떄만
//            //기본값으로 지정되는데, bulder()는 모든 매개변수를 갖는 생성자를
//            //호출하기 때문에 boardRegdate의 값이 null값으로 들어간다
//            Board board = Board.builder()
//                               .boardTitle(boardDTO.getBoardTitle())
//                               .boardContent(boardDTO.getBoardContent())
//                               .boardWriter(boardDTO.getBoardWriter())
//                               .boardRegdate((LocalDateTime.now()))
//                               .build();
//
//            boardService.insertBoard(board);
//
//            Map<String, String> returnMap = new HashMap<>();
//
//            returnMap.put("Msg", "정상적으로 저장되었습니다.");
//
//            responseDTO.setItem(returnMap);
//
//            return  ResponseEntity.ok().body(responseDTO);
//
//        } catch (Exception e) {
//            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
//            responseDTO.setErrorMessage(e.getMessage());
//
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//    }
//
//    @PutMapping("/board")
//    public  ResponseEntity<?> updateBoard(BoardDTO boardDTO) {
//        ResponseDTO<Map<String, String>> responseDTO = new ResponseDTO<>();
//
//        try{
//            Board board = Board.builder()
//                    .boardNo((boardDTO.getBoardNo()))
//                    .boardTitle(boardDTO.getBoardTitle())
//                    .boardContent(boardDTO.getBoardContent())
//                    .boardWriter(boardDTO.getBoardWriter())
//                    .build();
//
//            boardService.updateBoard(board); //위의 보드를 업데이트 보드로 보냄
//
//            Map<String, String> returnMap = new HashMap<>(); //리턴해줄 맵
//
//            returnMap.put("Msg", "정상적으로 저장되었습니다.");
//
//            responseDTO.setItem(returnMap);
//
//            return ResponseEntity.ok().body(responseDTO);
//
//        } catch (Exception e) {
//            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
//            responseDTO.setErrorMessage(e.getMessage());
//
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//
//    }
//
//    @DeleteMapping("/board")
//    public ResponseEntity<?> deleteBoard(BoardDTO boardDTO) {
//        ResponseDTO<Map<String, String>> responseDTO = new ResponseDTO<>();
//
//        try{
//            //인트로 보낼거라 엔티티(build) 따로 안만들어줘도됨
//
//            boardService.deleteBoard(boardDTO.getBoardNo());
//
//            Map<String, String> returnMap = new HashMap<>(); //리턴해줄 맵
//
//            returnMap.put("Msg", "정상적으로 저장되었습니다.");
//
//            responseDTO.setItem(returnMap);
//
//            return ResponseEntity.ok().body(responseDTO);
//
//        } catch (Exception e) {
//            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
//            responseDTO.setErrorMessage(e.getMessage());
//
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//    }
//
//    @GetMapping("/board")
//    public ResponseEntity<?> getBoard(BoardDTO boardDTO) {
//        ResponseDTO<BoardDTO> responseDTO = new ResponseDTO<>();
//
//        try{
//            //담아
//            Board board = boardService.getBoard(boardDTO.getBoardNo());
//
//            if (board != null) {
//                BoardDTO returnBoardDTO = BoardDTO.builder()
//                        .boardNo(board.getBoardNo())
//                        .boardTitle(board.getBoardTitle())
//                        .boardContent(board.getBoardContent())
//                        .boardWriter(board.getBoardWriter())
//                        .boardRegDate(board.getBoardRegdate().toString())
//                        .boardCnt(board.getBoardCnt())
//                        .build();
//
//                responseDTO.setItem(returnBoardDTO);
//            } else {
//                responseDTO.setErrorMessage("해당 게시글이 존재하지 않습니다.");
//            }
//
//            return ResponseEntity.ok().body(responseDTO);
//
//        } catch (Exception e) {
//            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
//            responseDTO.setErrorMessage(e.getMessage());
//
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//
//    }
//
//
//
//}
