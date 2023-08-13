import random
import threading
import time

tempo_min_espera = 1
tempo_max_espera = 1

lebre_pulando = threading.Lock()
resultados = []


class Lebre:
    nome = ''
    posicao = 0
    quant_pulos = 0

    def __init__(self, nome):
        self.nome = nome

    def pulo(self):
        self.quant_pulos += 1
        tamanho_pulo = random.randint(1, 3)
        self.posicao += tamanho_pulo
        print(f' A lebre {self.nome} deu um salto de {tamanho_pulo} metros\n')

    def verificar_pulo(self):
        while self.posicao < 20:
            with lebre_pulando:
                self.pulo()
            time.sleep(random.randint(tempo_min_espera, tempo_max_espera))
        resultados.append(self)


def corrida(lebre_nome):
    lebre = Lebre(lebre_nome)
    lebre.verificar_pulo()


if __name__ == '__main__':
    lebre1 = threading.Thread(target=corrida, args=["Amanda"])
    lebre2 = threading.Thread(target=corrida, args=["Paula"])
    lebre3 = threading.Thread(target=corrida, args=["Lucas"])
    lebre4 = threading.Thread(target=corrida, args=["Ravi"])
    lebre5 = threading.Thread(target=corrida, args=["Jennifer"])

    lebre1.start()
    lebre2.start()
    lebre3.start()
    lebre4.start()
    lebre5.start()

    lebre1.join()
    lebre2.join()
    lebre3.join()
    lebre4.join()
    lebre5.join()

    print('\n')
    print('Resultados da corrida: \n')

    print(f'A lebre "{resultados[0].nome}" venceu!\n')
    for posicao, lebre in enumerate(resultados):
        print(f'{lebre.nome} ficou em {posicao + 1}° lugar, com {lebre.quant_pulos} pulos.')