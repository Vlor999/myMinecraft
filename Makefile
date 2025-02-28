# Définition des variables
JAVA = $(JAVA_HOME)/bin/java
JAVAC = $(JAVA_HOME)/bin/javac
FX_MODULES = javafx.controls,javafx.fxml,javafx.graphics,javafx.swing
MODULE_PATH = $(PATH_TO_FX)

SRC = src
BIN = bin
FILE = Main

all: run

compile:
	@mkdir -p $(BIN)
	$(JAVAC) --module-path $(MODULE_PATH) --add-modules $(FX_MODULES) -d $(BIN) $(SRC)/$(FILE).java -classpath $(SRC)

run: compile
	$(JAVA) --module-path $(MODULE_PATH) --add-modules $(FX_MODULES) -cp $(BIN) $(FILE) -classpath $(SRC)

clean:
	rm -rf $(BIN)
