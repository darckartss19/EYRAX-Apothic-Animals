# EYRAX Apothic Animals 1.1.0

## English

EYRAX Apothic Animals is a NeoForge addon for Minecraft 1.21.1 that integrates
Critter Armory animal equipment with the Apotheosis affix and gem systems.

- Recognizes 25 armor items for chickens, wolves, cats, cows, pigs, sheep and
  horses.
- Adds eight balanced animal-specific affixes.
- Adds functional animal-armor bonuses to 20 native Apotheosis gems.
- Displays the exact gem benefit and value for the current purity.
- Includes English and Spanish translations.
- Does not add world generation, ores, structures or new entities.

### Requirements

- Minecraft 1.21.1
- NeoForge 21.1.248 or newer for Minecraft 1.21.1
- Apotheosis 8.7.0 or a newer compatible version
- Apothic Attributes 2.10.0 or a newer compatible version
- Critter Armory 1.21.1-0.6.5-neoforge or a newer compatible version

Install the mod on both the client and the server.

### Building from source

Java 21 is required. Clone the repository and run:

```bash
./gradlew build
```

The compiled JAR is created under `build/libs`. To launch a development client
or server with Critter Armory, place its JAR in `run/mods` first.

## Español

Complemento para Minecraft Java 1.21.1 con NeoForge. Integra las armaduras de
Critter Armory con los afijos de Apotheosis mediante una categoría real de
botín vinculada a la ranura `BODY` de Apothic Attributes.

## Qué hace

- Reconoce las armaduras de pollo, lobo, gato, vaca, cerdo, oveja y caballo.
- Permite aplicarles afijos en la mesa de reforja de Apotheosis.
- Los atributos se aplican al animal mientras lleva la armadura equipada.
- Incluye ocho afijos equilibrados: armadura, dureza, vida, velocidad,
  resistencia al empuje, daño de ataque, reducción de caída y de explosiones.
- Incluye nombres en español e inglés.
- Integra 20 gemas nativas de Apotheosis con la categoría de armadura animal.
- Cada gema muestra en su tooltip el beneficio exacto para armaduras animales
  y el valor correspondiente a su pureza.

El afijo `Espolón de guerra` aumenta el atributo de daño de ataque. Los gallos
de Modern Chickens disponen de ese atributo; por tanto, el aumento se usa al
realizar ataques que consulten el daño normal de la entidad. Los animales sin
capacidad de combate simplemente no aprovechan ese afijo.

## Requisitos exactos de esta versión

- Minecraft 1.21.1
- NeoForge 21.1.248 o posterior para 1.21.1
- Apotheosis 8.7.0 o posterior compatible
- Apothic Attributes 2.10.0 o posterior compatible
- Critter Armory 1.21.1-0.6.5-neoforge o posterior compatible

Debe instalarse tanto en el cliente como en el servidor. No reemplaza ninguno
de los mods anteriores.

## Instalación

1. Detén el servidor.
2. Copia `EYRAX-Apothic-Animals-1.1.0.jar` a la carpeta `mods` del servidor.
3. Añade el mismo JAR al perfil del cliente.
4. Inicia el servidor y revisa que no existan errores de carga de datos.
5. Prueba una armadura animal en la mesa de reforja de Apotheosis.

No requiere regenerar el mundo porque no añade minerales, estructuras ni
biomas. Tampoco activa la progresión de dificultad de Improved Mobs.

## Afijos incluidos

| Afijo | Efecto |
|---|---|
| Plumaje de hierro | Armadura adicional |
| Plumón de acero | Dureza de armadura |
| Corazón de corral | Vida máxima |
| Patas ligeras | Velocidad de movimiento |
| Bien plantado | Resistencia al empuje |
| Espolón de guerra | Daño de ataque |
| Aterrizaje con plumas | Reducción de daño por caída |
| Entrenado contra explosiones | Reducción de explosiones |

## Gemas para armaduras animales

Veinte gemas estándar de Apotheosis reciben una bonificación específica para
la categoría `Armadura animal`. Al mantener una gema bajo el cursor, Apotheosis
muestra automáticamente el nombre del atributo y su valor según la pureza.

Los efectos se limitan a atributos compatibles con entidades vivas: vida,
armadura, dureza, velocidad, daño, resistencia al empuje, perforación,
críticos, evasión, daño de fuego o frío, curación y robo de vida. No se usan
bonificaciones exclusivas del jugador, como alcance, minería o uso de bloques.

`Endersurge` queda sin una bonificación animal propia porque su efecto nativo
usa la categoría universal `Cualquier objeto`; Apotheosis rechaza por diseño
una segunda categoría que se superponga. No se fuerza ese conflicto.

| Gema | Beneficio para armadura animal |
|---|---|
| Ballast | Resistencia al empuje |
| Brawler's | Vida máxima |
| Breach | Perforación de armadura |
| Combatant | Daño de ataque fijo |
| Guardian | Armadura |
| Lightning | Velocidad de movimiento |
| Lunar | Daño de frío |
| Samurai | Probabilidad de crítico |
| Slipstream | Probabilidad de evasión |
| Solar | Daño de fuego |
| Splendor | Curación recibida |
| Tyrannical | Dureza de armadura |
| Warlord | Daño de ataque porcentual |
| Earth | Armadura y dureza |
| Royalty | Vida, armadura, velocidad y daño |
| Verdant Ruin | Curación y resistencia al empuje |
| Mageslayer | Desgaste de protección |
| Blood Lord | Robo de vida |
| Inferno | Daño de fuego mejorado |
| Molten Breach | Daño y perforación de armadura |

## Compatibilidad futura

La etiqueta `#eyrax_apothic_animals:animal_armor` es extensible. Otros mods o
datapacks pueden añadir sus armaduras animales a esa etiqueta sin modificar el
código Java.
