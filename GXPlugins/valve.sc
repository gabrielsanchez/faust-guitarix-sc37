FaustValve : UGen
{
  *ar { | in1, dist(0.0), q(0.0) |
      ^this.multiNew('audio', in1, dist, q)
  }

  *kr { | in1, dist(0.0), q(0.0) |
      ^this.multiNew('control', in1, dist, q)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustValve" }


  info { ^"Generated with Faust" }
}

