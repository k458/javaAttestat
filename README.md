Андрей Булгаков・Преподаватель
Здравствуйте, Игорь!
Рабочее решение. Минус - в множество попадут одинаковые ноутбуки, не переопределены методы equals и hashCode.
Некорректная структура класса Notebook с точки зрения ООП, должен содержать данные по конкретному объекту (ноутбуку). Сейчас в нём функционал, не относящийся непосредственно к конкретному экземпляру. Набор возможных параметров должен храниться в базе данных (отдельном файле). Рандомное создание ноутбука должно быть реализовано отдельно, передавая параметры через конструктор класса.
Сканер (scanner) нужно закрывать.
Плюс - решение самостоятельное, оригинальное.
По итогу 5-.
