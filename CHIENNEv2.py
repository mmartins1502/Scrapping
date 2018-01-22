import requests
import re
import time
from Tkinter import *
from tkFileDialog import * 
import tkSimpleDialog
import sys
import tkFileDialog
from tkFileDialog import askopenfilename
import tkMessageBox


def cleanhtml(raw_html):
	cleanr = re.compile('<.*?>')
	cleantext = re.sub(cleanr, '', raw_html)
	return cleantext

fenetre = Tk()
fenetre.title('SERVEUR PROFESSIONNEL DE DONNEES CADASTRALES')

label = Label(fenetre, text="SERVEUR PROFESSIONNEL DE DONNEES CADASTRALES", padx=10, pady=10)
label.pack()
spdc = tkSimpleDialog.askstring("SPDC", "Quel est votre cookie SPDC ?")
# print spdc
lemondgfip = tkSimpleDialog.askstring("LEMONDGFIP", "Quel est votre cookie LEMONDGFIP ?")
# print lemondgfip
QUITTER = Button(fenetre, text ='QUITTER', command = quit)
QUITTER.pack()



cookies = 	{
				'ASPSESSIONIDASQQTTAS': 'CELGPPJDEDFBAJOFLDJJJMPN',
				'ASPSESSIONIDSSQSQQDQ': 'LFMIAKLDOBOGFFKJJBDFFILC',
				'ASPSESSIONIDSSRTTQBR': 'HOLGNJLDDLPCLJEGEMKOKMOK',
				'ASPSESSIONIDQQTTSRAQ': 'FAADPJMDPKACGMOPAMJGOLAK',
				'ASPSESSIONIDSQQQTQCQ': 'EGDFHKMDPHDHCHIAINEIHJCH',
				'jamyMailAdr': 'sebastien%2Edurand%40notaires%2Efr',
				'jamyDroits': 'T',
				'Annuaire': 'O',
				'jamyDNUser': 'uid%3DA00QWCCXVJ%2Cuid%3DOKZCD1NP5U%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr',
				'ckProfilcat': 'Consult',
				'jamyDNStructure': 'uid%3DOKZCD1NP5U%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr',
				'perstrace': 'S+DURAND',
				'TypeStruct': 'O',
				'CcodepM1': '000',
				'CcocomM1': '+++',
				'M1EnCours': '0',
				'Office': 'OKZCD1NP5U',
				'Utilisateur': 'A00QWCCXVJ',
				'spdc': spdc,
				'lemondgfip': lemondgfip
			}

result = open("resultats.csv", "w+")
# data = open('data.csv', 'r')
data = tkFileDialog.askopenfilename(title="Ouvrir votre document",filetypes=[('txt files','.csv'),('all files','.*')])
# print data
d = open(data, 'r')
for string in d:
	string = string.rstrip('\r\n')
	code = string.split(',')
	payload = 	{	
					'txtOffice': 'OKZCD1NP5U', 
					'txtCcodep': code[0],
					'txtCcocom': code[1],
					'txtUtilisateur': 'A00QWCCXVJ',
					'txtCcoprf': '',  
					'txtCcosec': code[2],
					'txtDnupla': code[3],
					'txtTypeTrait': '10',
					'txtSession': spdc
				}


	r = requests.get('http://spdc.dgfip.finances.gouv.fr/cdc_titulaires.asp', cookies=cookies, params=payload)

	file = r.content.splitlines()[50:58]

	for line in file:
		if line == "\n":
			line.delete()
		result.write(cleanhtml(line.strip()) + ', ')
		# print(cleanhtml(line.strip()))
	result.write("\n")
	time.sleep(5)

tkMessageBox.showinfo("Operation Reussie", "Un fichier 'resultats.csv' , avec tous vos resultats, vient d'etre cree !")
fenetre.mainloop()




#########################################################################################

# f = open('cookies', 'r')
# spdc = str(f.readline()).rstrip('\n')
# lemondgfip = str(f.readline()).rstrip('\n')
# jamyDNStructure = str(f.readline()).rstrip('\n')
# jamyDNuser = str(f.readline()).rstrip('\n')
# f.close()
# print jamyDNStructure
# print jamyDNuser


# print (file)


# result = file.readlines()
# file.seek(0)
# for i in result:
#     if i != "\n":
#         file.write(i)
# file.truncate()
# for line in file:
# 	if line == "\n":
# 	result.write(cleanhtml(line.strip()) + ', ')
# 	print(cleanhtml(line.strip()))