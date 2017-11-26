all:
	@gcc -o chess chess.c -Wall -Werror -Wextra

test: all
	@./chess
