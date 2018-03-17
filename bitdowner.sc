FaustBitDowner : UGen
{
  *ar { | in1, bit_down(16.0), downsampling(1.0), input_gain(0.0), volume(0.0) |
      ^this.multiNew('audio', in1, bit_down, downsampling, input_gain, volume)
  }

  *kr { | in1, bit_down(16.0), downsampling(1.0), input_gain(0.0), volume(0.0) |
      ^this.multiNew('control', in1, bit_down, downsampling, input_gain, volume)
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

  name { ^"FaustBitDowner" }


  info { ^"Generated with Faust" }
}

