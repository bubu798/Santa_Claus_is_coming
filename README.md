VARIABILE:

iterator, sumPonder, averageSum = varabile folosite pentru calcularea scorului average
budgetUnit, spent = variabile folosite pentru calcularea bugetului

input = varabila pentru citirea inputului

cityNameList = lista de orase
scoreListNew = lista de obiecte care contin id si scor
newList = lista folosita pentru a copia copii folosind copy constructor, pentru output
cityList = lista de obiecte de tip City, folosita pentru a ordona orasele dupa scor si nume
listaCadouri = lista folosita pentru alocarea cadourilor in functia assignGifts
spent = varabila folosita in functia assignGifts pentru a calcula suma de bani consumati pe cadourile unui copil

FUNCTII:

assignGifts 
	- se verifica daca copilul are pana in 18 ani
	- se itereaza prin lista de preferinte a copilului
	- se completeaza variabila listaCadouri cu cadouri care coincid cu preferintele copilului
	- se gaseste cel mai ieftin cadou din listaCadouri
	- se verifica daca acel cadou are cantitatea mai mare decat 0 si daca copilul are bugetul necesar pentru a cumpara acel cadou, caz in care cadoul este adaugat in lista de cadouri a copilului, cantitatea cadoului este decrementata si valoarea cadoului este adaugata in variabila spent.
	
PROGRAM:

primul for este pentru inputuri, fiecare iteratie reprezinta rezolvarea unui input

al doilea for este pentru a itera prin numarul de ani, j reprezinta numarul anului curent

se verifica daca anul curent nu este anul 0, caz in care se face update listei de copii, preferintele copiilor, elfului copiilor, listei cu nice scoreuri ale copiilor, bugetului mosului si listei de cadouri ale mosului

urmatorul for clasifica copiii in functie de varsta lor si calculeaza nice score-ul in functie de aceasta, dupa care se adauga orasele copiilor in lista de orase, si score-urile impreuna cu id-ul in lista scoreListNew.

urmatorul for calculeaza media de scor pentru fiecare oras

se face sortarea in mod descrescator a oraselor in functie de average score si numele orasului

este calculat budgetUnitul in functie de buget si suma scorurilor tututor copiilor

se face sortarea in mod descrescator a listei de score-uri in functie de scor si id

urmatorul for aplica modificarile aduse bugetului copiilor pentru copiii care au elfi de tip BLACK si PINK

in functie de strategia de alocare a cadourilor pentru anul respectiv se face alocarea cadourilor folosind functia assignGifts. 

se imarte un cadou copiilor cu elful YELLOW daca este disponibil.

se copiaza lista de copii in in variabila newList folosind copy construcotr pentru a nu se modifica aceasta lista la urmatoare iteratie.

se adauga newList intr-o lista de liste folosita petnru output.
se golesc toate listele folosite pentru a fi folosite iar in urmatoarea iteratie.