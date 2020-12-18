Projeto teste Abrigo Animal

Construa um sistema para um abrigo animal, o usuário deverá acessar o sistema através de dois endpoints:

**recepcao de animais:** usado para adicionar um novo animal no abrigo. O usuário precisa informar o nome, tipo (GATO ou CACHORRO) e a saúde do animal (SAUDAVEL, DOENTE).

**adotar:** usado quando o animal for adotado, o usuário informa o tipo do animal (CACHORRO ou GATO), o sistema retorna o animal mais antigo do abrigo e atualiza a data de adoção no banco de dados.

Internamente, a cada 2 minutos um animal aleatório deve mudar sua saúde para um dos seguintes casos:

    - de saudável para doente
    - de doente para morto
    - de doente para saudável

Regras:

    - apenas animais saudáveis podem ser adotados
    - apenas o animal com data de entrada mais antiga pode ser adotado
    - um animal pode ser adotado apenas uma vez
    - um animal morto não poderá ser adicionado ao abrigo
