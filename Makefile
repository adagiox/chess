all:
	@gcc -o chess chess.c -Wall -Werror -Wextra -lncurses

test: all
	@./chess
