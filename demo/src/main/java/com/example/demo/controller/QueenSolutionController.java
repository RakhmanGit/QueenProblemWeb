package com.example.demo.controller;


import com.example.demo.model.DTO.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solution")
public class QueenSolutionController {

    @GetMapping("/{str}/{stb}")
    public ResponseDto solution(@PathVariable int str, @PathVariable int stb)
    {
        ResponseDto responseDto = new ResponseDto();
        StringBuilder answer = new StringBuilder();
        QueenProblem queenProblem = new QueenProblem();
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                queenProblem.chessboard[i][j] = 0;
        queenProblem.checkPosition(0);
        queenProblem.setFigure(str,stb);
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (queenProblem.chessboard[i][j] == -1) {
                    answer.append(" 1 ");
                }
                else
                    answer.append(" 0 ");
            }
            answer.append(System.getProperty("line.separator"));
        }
        responseDto.setAnswer(answer);
        return responseDto;
    }

    public class QueenProblem {
        int chessboard[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0}
        };
        public boolean checkPosition(int i) {
            boolean result = false;
            for (int j = 0; j < 8; ++j) {
                if (chessboard[i][j] == 0) {
                    setFigure(i,j);
                    if (i==7){
                        result = true;
                    }
                    else {
                        if (!(result = checkPosition(i+1)))
                            resetFigure(i,j);
                    }
                }
                if (result)
                    break;
            }
            return result;
        }
        public void resetFigure(int i, int j) {
            for (int x=0;x<8; ++x) {
                --chessboard[x][j];
                --chessboard[i][x];
                int foo;
                foo = j - i + x;
                if (foo >= 0 && foo <8)
                    --chessboard[x][foo];
                foo = j + i - x;
                if (foo >= 0 && foo <8)
                    --chessboard[x][foo];
            }
            chessboard[i][j] = 0;
        }
        public void setFigure(int i, int j) {
            for (int x=0;x<8; ++x) {
                ++chessboard[x][j];
                ++chessboard[i][x];
                int foo;
                foo = j - i + x;
                if (foo >= 0 && foo <8)
                    ++chessboard[x][foo];
                foo = j + i - x;
                if (foo >= 0 && foo <8)
                    ++chessboard[x][foo];
            }
            chessboard[i][j] = -1;
        }
        }
    }

