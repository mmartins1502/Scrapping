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

######################################## INTERFACE ##################################################

fenetre = Tk()
fenetre.title('SERVEUR PROFESSIONNEL DE DONNEES CADASTRALES')

label = Label(fenetre, text="SERVEUR PROFESSIONNEL DE DONNEES CADASTRALES", padx=10, pady=10)
label.pack()
spdc = tkSimpleDialog.askstring("SPDC", "Quel est votre cookie SPDC ?")
lemondgfip = tkSimpleDialog.askstring("LEMONDGFIP", "Quel est votre cookie LEMONDGFIP ?")
QUITTER = Button(fenetre, text ='QUITTER', command = quit)
QUITTER.pack()


######################################## COOKIES ##################################################


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


######################################## PARSING ##################################################


result = open("resultats.csv", "w+")
data = tkFileDialog.askopenfilename(title="Ouvrir votre document",filetypes=[('txt files','.csv'),('all files','.*')])
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


######################################## REQUEST ##################################################


	r = requests.get('http://spdc.dgfip.finances.gouv.fr/cdc_titulaires.asp', cookies=cookies, params=payload)


######################################## DATA RECOVERY ##################################################


	file = r.content.splitlines()[50:58]

	for line in file:
		if line == "\n":
			line.delete()
		result.write(cleanhtml(line.strip()) + ', ')
	result.write("\n")
	time.sleep(5)

tkMessageBox.showinfo("Operation Reussie", "Un fichier 'resultats.csv' , avec tous vos resultats, vient d'etre cree !")
fenetre.mainloop()