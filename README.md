```bash
python nrainhas.py              # pede n interativamente (>= 2)
python nrainhas.py 7            # uma solução (tabuleiro com Q)
python nrainhas.py 7 --todas    # todas as soluções com tabuleiro
python nrainhas.py --demo       # exemplos automáticos
python soma_subconjuntos.py                    #     pede o conjunto
python soma_subconjuntos.py -7 -3 -2 5 8           # primeira solução
python soma_subconjuntos.py -7 -3 -2 5 8 --todas
python soma_subconjuntos.py --demo
python benchmark.py
```

## complexidade
| problema | uma solução | todas |
|----------|-------------|-------|
| n-rainhas | o(n!) tempo, o(n) espaço | o(n!) tempo, o(n·s) espaço |
| soma zero | o(2^n) tempo, o(n) espaço | o(2^n) tempo, o(n+s·n) espaço |
- iteração = cada chamada do `backtrack`
- instrução = comparações e tentativas contadas no código

## resultados dos exemplos
### n-rainhas — primeira solução
| n | soluções | iterações | instruções | tempo (s) |
|---|----------|-----------|------------|-----------|
| 4 | 1 | 9 | 107 | 0.000050 |
| 6 | 1 | 32 | 913 | 0.000227 |
| 8 | 1 | 114 | 5866 | 0.001644 |
| 10 | 1 | 103 | 7422 | 0.001652 |
| 12 | 1 | 262 | 26838 | 0.005729 |

### n-rainhas — todas as soluções
| n | soluções | iterações | instruções | tempo (s) |
|---|----------|-----------|------------|-----------|
| 4 | 2 | 17 | 245 | 0.000084 |
| 6 | 4 | 153 | 5079 | 0.001145 |
| 7 | 40 | 552 | 22730 | 0.007939 |
| 8 | 92 | 2057 | 111281 | 0.088765 |

### soma zero — primeira solução
| entrada | soluções | iterações | instruções | tempo (s) |
|---------|----------|-----------|------------|-----------|
| {-7,-3,-2,5,8} | 1 | 36 | 55 | 0.000048 |
| {1,2,3,4,5,10} | 0 | 127 | 190 | 0.000080 |
| {-5,2,3,-1,1} | 1 | 4 | 7 | 0.000004 |

### soma zero — todas as soluções
| entrada | soluções | iterações | instruções | tempo (s) |
|---------|----------|-----------|------------|-----------|
| {-7,-3,-2,5,8} | 1 | 63 | 94 | 0.000058 |
| {1,2,3,4,5,10} | 0 | 127 | 190 | 0.000080 |
| {-5,2,3,-1,1} | 3 | 63 | 94 | 0.000045 |

### soma zero — sem solução, pior caso o(2^n)
| tamanho | soluções | iterações | instruções | tempo (s) |
|---------|----------|-----------|------------|-----------|
| 10 | 0 | 2047 | 3070 | 0.001230 |
| 15 | 0 | 65535 | 98302 | 0.115920 |
| 18 | 0 | 524287 | 786430 | 0.763660 |
| 20 | 0 | 2097151 | 3145726 | 2.500606 |

### soma zero — conjuntos grandes aleatórios (positivos e negativos)
| tamanho | soluções | iterações | instruções | tempo (s) |
|---------|----------|-----------|------------|-----------|
| 50 | 1 | 2986 | 4499 | 0.001734 |
| 100 | 1 | 1266044 | 1899111 | 1.518476 |

`python benchmark.py` para gerar os resultados.