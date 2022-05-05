# Minecraft Matrices Generator [MMG]

A tool created to use commands to generate an adjacency list of all your positions, with rendering to show off all your points before you compile them to JSON.

## Commands

| Command           | Description                                                  | Usage                     |
| ----------------- | ------------------------------------------------------------ | ------------------------- |
| **start**         | Initiates your matrices list. Must be done before adding your points. | /mmg start                |
| **addpoint**      | Adds a point (node) to your list based on the position you are standing. | /mmg addpoint             |
| **deletepoint**   | Deletes a point (node) from your list, as well as all references from other points. | /mmg deletepoint [node]   |
| **addconnection** | Adds a connection (vertex) to the point (node) you mention, from the point you are standing on. | /mmg addconnection [node] |
| **finish**        | Compiles your matrices to a json file, and opens it for you. | /mmg finish               |

Note that 'addconnection' requires you to be standing on a node, to connect it to the node you mention in the command.

## Preview

![img](https://i.gyazo.com/67fa5a18ad882342de7bce3b7d07e7e5.png)

## Compiled Example

This just shows the first few nodes of the list... because this file is 2000 lines long.

```json
{
  "A": {
    "name": "A",
    "position": {
      "x": -129,
      "y": 74,
      "z": -195
    },
    "connectedTo": [
      "B"
    ]
  },
  "B": {
    "name": "B",
    "position": {
      "x": -132,
      "y": 74,
      "z": -183
    },
    "connectedTo": [
      "A",
      "H",
      "G",
      "C",
      "E"
    ]
  },
  "C": {
    "name": "C",
    "position": {
      "x": -146,
      "y": 74,
      "z": -183
    },
    "connectedTo": [
      "B",
      "D",
      "E"
    ]
  },
    
...
```
