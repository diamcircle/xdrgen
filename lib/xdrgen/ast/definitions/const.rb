module Xdrgen::AST
  module Definitions
    class Const < Base
      include Concerns::Named
      include Concerns::Contained
      
      delegate :value, to: :constant
    end
  end
end