from random import randint
import threading
import time

# Cria uma lista de cinco lebres
lebres = ['Lebre 1', 'Lebre 2', 'Lebre 3', 'Lebre 4', 'Lebre 5']

# Inicializa a distância percorrida e o num de pulos dados por cada lebre em 0
distancia_percorrida = [0] * len(lebres)
numero_de_pulos = [0] * len(lebres)

threads = []

# Função que executa a corrida
def correr(lebre):
    global distancia_percorrida
    global numero_de_pulos

    # Enquanto a distância percorrida pela lebre for menor que a distância total da corrida (20)
    while distancia_percorrida[lebres.index(lebre)] < 20:

        # Gera um número aleatório de 1 a 3
        salto = randint(1, 3)

        # Adiciona o comprimento do salto à distância percorrida pela lebre
        distancia_percorrida[lebres.index(lebre)] += salto
        print(lebre, 'pulou', salto, 'metros\n')

        # Implementar modulo para lebre esperar sua vez, por enquanto a lebre aguarda um tempo aleatorio
        #lebres.index(lebre).wait
        time.sleep(randint(1, 5))

        # Incrementa o número de pulos dados pela lebre
        numero_de_pulos[lebres.index(lebre)] += 1

        # Verifica se os 20 metros já foram percorridos pela lebre
        if distancia_percorrida[lebres.index(lebre)] >= 20:
            break

# Inicia as threads para as cinco lebres
for lebre in lebres:
    threads.append(threading.Thread(target=correr, args=[lebre]))

# Inicia as threads
for thread in threads:
    thread.start()

# Aguarda todas as threads terminarem
for thread in threads:
    thread.join()

# Encontra a lebre vencedora
vencedora = lebres[distancia_percorrida.index(max(distancia_percorrida))]

# Imprime a colocação de cada lebre
for i in range(len(lebres)):
    print(lebres[i], 'ficou em', i + 1, 'lugar', 'com', numero_de_pulos[i], 'pulos\n')

# Imprime a lebre vencedora
print('A lebre vencedora foi', vencedora, '\n')
