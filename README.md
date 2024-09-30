# Bank-interface
## Projekt
Centrum obsługi kart płatniczych obsługuje płatności kartami kredytowymi, debetowymi i bankomatowymi. Z żądaniem autoryzacji każdej płatności mogą zwracać się sklepy, zakłady usługowe i firmy transportowe (to są klienci centrum). Centrum autoryzuje płatność po wysłaniu zapytania do banku który wydał daną kartę płatniczą a informację o tym archiwizuje w postaci wpisu w swoim systemie bazodanowym, które można przeszukiwać.
Uwaga: klienci firm są też klientami banku i tam mają konta - nie muszą być rejestrowani w firmach, płatność odbywa się (jak w rzeczywistości) podając dane karty i kwotę. Są 2 relacje klient: firma jest klientem centrum, osoba jest klientem firmy i zarazem klientem banku, w którym ma konto.
### Minimalny zakres funkcjonalności:
- zarządzenie firmami korzystającymi z centrum centrum i bankami (dodawanie, usuwanie, przegląd)
- zarządzanie kartami (przypisana do klienta banku, wydana przez bank)
- obsługa żądań autoryzacji (kwota, data, dane karty) - decyzja zależna od rodzaju karty
- zapis i odczyt stanu systemu na dysk (realizacja archiwum operacji w postaci odrębnego pliku)
- przeszukiwanie archiwum za pomocą złożonych warunków (firma, bank, numer karty, właściciel, kwota, warunki OR i AND)

## Screeny
![image1](https://github.com/user-attachments/assets/83401464-c289-40e7-8127-094dc15d3d1a)
![image2](https://github.com/user-attachments/assets/411496d2-1e4d-47b2-87ac-85da97b5d64b)
![image3](https://github.com/user-attachments/assets/6a1f6e5c-3b75-4390-9157-37ed5441f873)
![image4](https://github.com/user-attachments/assets/633cb1e7-6df9-448b-b250-2a6861d92c86)
![image5](https://github.com/user-attachments/assets/82f98f5b-cd64-4973-bd0a-3d53fceece67)
![image6](https://github.com/user-attachments/assets/7796dd8a-aa8f-4203-9d63-b8d3f68a61f3)
![image7](https://github.com/user-attachments/assets/12da2b8e-7e5e-4938-bb6a-eb2a35459a81)

## Instrukcja Uruchomienia
- Pobierz repozytorium, wykonując polecenie: git clone https://github.com/KamYloo/Bank-interface.git
- Otwórz projekt w środowisku Intellij lub innym edytorze do języka Java.
- Zbuduj i uruchom aplikację.
Przed uruchomieniem upewnij się, że wszystkie niezbędne zależności zostały poprawnie zainstalowane.
